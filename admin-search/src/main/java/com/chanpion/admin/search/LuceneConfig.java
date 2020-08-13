package com.chanpion.admin.search;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.ControlledRealTimeReopenThread;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.SearcherFactory;
import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author April Chen
 * @date 2020/8/13 16:10
 */
@Configuration
public class LuceneConfig {

    private static final String LUCENE_INDEX_PATH = "/lucene/index/";

    @Bean
    public Analyzer analyzer() {
        return new SmartChineseAnalyzer();
    }

    @Bean
    public Directory directory() throws IOException {
        Path path = Paths.get(LUCENE_INDEX_PATH);
        File file = path.toFile();
        if (!file.exists()) {
            file.mkdirs();
        }
        return FSDirectory.open(path);
    }

    @Bean
    public IndexWriter indexWriter(Directory directory, Analyzer analyzer) throws IOException {
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        indexWriter.deleteAll();
        indexWriter.commit();
        return indexWriter;
    }

    @Bean
    public SearcherManager searcherManager(IndexWriter indexWriter) throws IOException {
        SearcherManager searcherManager = new SearcherManager(directory(), new SearcherFactory());
        ControlledRealTimeReopenThread<IndexSearcher> thread = new ControlledRealTimeReopenThread<>(indexWriter, searcherManager, 5.0, 0.025);
        thread.setDaemon(true);
        thread.setName("lucene-thread");
        thread.start();
        return searcherManager;
    }
}
