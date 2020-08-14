package com.chanpion.admin.search;

import org.apache.lucene.analysis.TokenStream;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;

/**
 * @author April Chen
 * @date 2020/8/14 15:59
 */
public class AnalyzerTest {

    public static void main(String[] args) throws IOException {
        IKAnalyzer analyzer = new IKAnalyzer();
        TokenStream ts = analyzer.tokenStream("name", "护眼带光源，用户管理");
        ts.reset();
        while (ts.incrementToken()) {
            System.out.println(ts.reflectAsString(false));
        }
    }
}
