package br.com.lepsistemas.imagetwittertext;

import java.io.BufferedReader;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.lepsistemas.imagetwittertext.scanner.ImageCracker;

@SpringBootApplication
public class ImageTwitterTextApplication {

	public static void main(String[] args) throws URISyntaxException {
//		SpringApplication.run(ImageTwitterTextApplication.class, args);
		String crackImage = new ImageCracker().crackImage("tweet.png");
		List<String> lines = new BufferedReader(new StringReader(crackImage)).lines().collect(Collectors.toList());
		System.out.println("authorName: " + lines.get(0).substring(2, lines.get(0).length() - 2));
		System.out.println("authorUsername: " + lines.get(1).substring(lines.get(1).indexOf('@')));
		System.out.println("postDate: " + lines.get(lines.size() - 3));
		String post = "";
		for (int i = 2; i < lines.size() - 3; i++) {
			post += lines.get(i) + " ";
		}
		System.out.println("post: " + post);
		String[] actions = lines.get(lines.size() - 2).split(" ");
		System.out.println("retweets: " + actions[actions.length - 3]);
		System.out.println("likes: " + actions[actions.length - 1]);
	}
}
