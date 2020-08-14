package com.chanpion.admin.system;

import com.chanpion.admin.system.entity.Menu;
import com.chanpion.admin.system.service.MenuService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author April Chen
 * @date 2020/8/13 19:57
 */
@Component
public class MenuSearcher implements ApplicationRunner {
    @Resource
    private MenuService menuService;

    @Resource
    private IndexWriter indexWriter;

    @Resource
    private SearcherManager searcherManager;

    @Resource
    private Analyzer analyzer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Menu> menus = menuService.findAll();
        menus.forEach(menu -> {
            Document document = new Document();
            document.add(new StringField("name", menu.getName(), Field.Store.YES));
            document.add(new LongPoint("id", menu.getId()));
            document.add(new StringField("pid", menu.getPid() + "", Field.Store.YES));
            try {
                indexWriter.addDocument(document);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        indexWriter.commit();

        search("用户");
    }

    public List<Document> search(String name) throws IOException, ParseException {
        IndexSearcher indexSearcher = searcherManager.acquire();
        QueryParser qp = new QueryParser("name", analyzer);
        qp.setDefaultOperator(QueryParser.OR_OPERATOR);
//        Query query = qp.parse(name);
        Query query = new TermQuery(new Term("name", name));
        TopDocs topDocs = indexSearcher.search(query, 10);
        System.out.println("查询结果的总数" + topDocs.totalHits);
        //遍历查询结果
        List<Document> documents = new ArrayList<>();

        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            //scoreDoc.doc 属性就是document对象的id
            Document doc = indexSearcher.doc(scoreDoc.doc);
            System.out.println(doc.getField("name"));
            System.out.println(doc.getField("pid"));
            documents.add(doc);
        }
        return documents;
    }
}
