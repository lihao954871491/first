package com.itheima.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrManager {
	
	//���
	@Test
	public void addSolr() throws Exception{
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/collection1"); 
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "7");
		document.addField("name", "é�޴����ʺ");
		document.addField("content", "ʺ���Բ����Ⱥ���");
		document.addField("title", "change");
		solrServer.add(document);
		solrServer.commit();
	}
	
	//�޸�
	@Test
	public void updateSolr() throws Exception {
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/collection1"); 
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "2");
		document.addField("name", "äɮ�Ľ����");
		document.addField("content", "ʺ����");
		solrServer.add(document);
		solrServer.commit();
	}
	//ɾ��
	@Test
	public void deleteSolr() throws SolrServerException, IOException {
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/collection1"); 
		
		//solrServer.deleteById("1");
		solrServer.deleteByQuery("title:change");
		solrServer.commit();
	}
	
	//��ѯ
	@Test
	public void SelectSolr() throws Exception {
		SolrServer solrServer = new HttpSolrServer("http://localhost:8080/solr/collection1"); 
		SolrQuery query = new SolrQuery();
		query.setQuery("title:change.me");
		QueryResponse response = solrServer.query(query);
		SolrDocumentList solrDocumentList = response.getResults();
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("name"));
			System.out.println(solrDocument.get("title"));
			System.out.println("������"+solrDocumentList.getNumFound());
		}
		solrServer.commit();
	}

}
