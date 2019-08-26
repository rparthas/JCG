package com.jcg.springBatch;

import com.jcg.springBatch.entity.Movie;
import com.jcg.springBatch.entity.MovieGenre;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job movieJob(Step movieStep) {
        return jobBuilderFactory.get("movieJob")
                .incrementer(new RunIdIncrementer())
                .flow(movieStep)
                .end()
                .build();
    }

    @Bean
    public Step movieStep() throws MalformedURLException {
        return stepBuilderFactory
                .get("movieStep")
                .<Movie, MovieGenre>chunk(10)
                .reader(jsonItemReader())
                .processor(movieListItemProcessor())
                .writer(movieGenreWriter())
                .build();
    }

    @Bean
    public JsonItemReader<Movie> jsonItemReader() throws MalformedURLException {
        return new JsonItemReaderBuilder<Movie>()
                .jsonObjectReader(new JacksonJsonObjectReader<>(Movie.class))
                .resource(new UrlResource("https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json"))
                .name("movieJsonItemReader")
                .build();
    }

    @Bean
    public ItemProcessor<Movie, MovieGenre> movieListItemProcessor() {
        return movie -> new MovieGenre(movie.getTitle(), movie.getGenres().toString());
    }

    @Bean
    public FlatFileItemWriter<MovieGenre> movieGenreWriter() {
        return new FlatFileItemWriterBuilder<MovieGenre>()
                .name("movieGenreWriter")
                .resource(new FileSystemResource("out/movies.csv"))
                .headerCallback(writer -> writer.write("Movie Title,Movie Genres"))
                .delimited()
                .delimiter(",")
                .names(new String[]{"title", "genre"})
                .build();
    }
}
