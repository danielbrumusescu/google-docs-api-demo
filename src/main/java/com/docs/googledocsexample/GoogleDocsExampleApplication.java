package com.docs.googledocsexample;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.docs.v1.Docs;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.collect.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@SpringBootApplication
public class GoogleDocsExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleDocsExampleApplication.class, args);
	}

	@Bean
	public Docs docsClient() throws IOException {
		GoogleCredentials credentials = GoogleCredentials.fromStream(new ClassPathResource("service_account_key.json").getInputStream())
				.createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform","https://www.googleapis.com/auth/documents"));


		Docs docsClient = new Docs.Builder(new NetHttpTransport(),new GsonFactory(),new HttpCredentialsAdapter(credentials)).setApplicationName("google-docs-api-example").build();

		return docsClient;
	}

}
