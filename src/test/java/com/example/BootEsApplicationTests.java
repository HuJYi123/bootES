package com.example;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class BootEsApplicationTests {

//	@Autowired
	RestHighLevelClient client;

	@Test
	void contextLoads() throws IOException {
		//设置访问路径
		HttpHost host = HttpHost.create("http://localhost:9200");
		RestClientBuilder builder = RestClient.builder(host);
		//实例化客户端
		client = new RestHighLevelClient(builder);

		//创建索引名
		CreateIndexRequest request = new CreateIndexRequest("books");
		//执行创建索引
		client.indices().create(request, RequestOptions.DEFAULT);
		client.close();
	}

}
