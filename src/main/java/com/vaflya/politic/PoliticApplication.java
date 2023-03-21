package com.vaflya.politic;

import com.vaflya.politic.quiz.Answer;
import com.vaflya.politic.quiz.Question;
import com.vaflya.politic.quiz.Quiz;
import com.vaflya.politic.quiz.Weight;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PoliticApplication {

	public static void main(String[] args) {
		Answer ans1_1 = new Answer("Я поддерживаю государственное регулирование экономики"
				,new Weight("socialism",0.01),new Weight("socialism",0.1),new Weight("communism",0.2));
		Answer ans1_2 = new Answer("Я против государственного регулирования экономики",
				new Weight("libertarianism",0.1),new Weight("anarchism",0.1));
		Answer ans1_3 = new Answer("Я считаю, что государство должно иметь регулирующую роль в экономике, но не должно полностью контролировать ее",
				new Weight("centrism",0.1));
		Question q1 = new Question("Какое отношение вы имеете к государственному регулированию экономики", ans1_1,ans1_2,ans1_3);

		Answer ans2_1 = new Answer("Я поддерживаю национальные традиции и обычаи",
				new Weight("monarchy",0.1), new Weight("fascism",0.05));
		Answer ans2_2 = new Answer("Я считаю, что национальные традиции и обычаи могут быть вредными и должны быть преодолены",
				new Weight("communism",0.1), new Weight("centrism",0.1));
		Answer ans2_3 = new Answer("Я против национализма и национальных традиций, и считаю, что из всех культурных традиций должна быть выборочно сохранена только та, которая согласуется с универсальными ценностями",
				new Weight("liberalism",0.1), new Weight("cosmopolitanism",0.1));
		Question q2 = new Question("Какое отношение вы имеете к национальным традициям и обычаям?", ans2_1, ans2_2, ans2_3);
		Answer ans3_1 = new Answer("Я поддерживаю абсолютную власть одного правителя или монарха",
				new Weight("monarchy",0.1), new Weight("fascism",0.1));
		Answer ans3_2 = new Answer("Я считаю, что абсолютную власть не допустима, политическая власть должна быть распределена",
				new Weight("libertarianism",0.1), new Weight("socialism",0.05));
		Answer ans3_3 = new Answer("Я не интересуюсь политикой",
				new Weight("centrism",0.1));
		Question q3 = new Question("Какое отношение вы имеете к политической власти?", ans3_1, ans3_2, ans3_3);

		Answer ans4_1 = new Answer("Я поддерживаю абсолютную власть одного правителя или монарха",
				new Weight("monarchy",0.1), new Weight("fascism",0.1));
		Answer ans4_2 = new Answer("Я считаю, что абсолютную власть не допустима, политическая власть должна быть распределена",
				new Weight("libertarianism",0.1), new Weight("socialism",0.05));
		Answer ans4_4 = new Answer("Я не интересуюсь политикой",
				new Weight("centrism",0.1));
		Question q4 = new Question("Какое отношение вы имеете к политической власти?", ans1_1, ans1_2, ans1_3);

		Answer ans5_1 = new Answer("Я считаю, что каждый человек должен иметь полную свободу выбора в отношении своей личной жизни",
				new Weight("libertarianism",0.1));
		Answer ans5_2 = new Answer("Я считаю, что государство должно регулировать определенные аспекты личной жизни людей",
				new Weight("fascism",0.1),new Weight("communism",0.1));
		Answer ans5_3 = new Answer("Я считаю, что государство должно регулировать личные свободы, но не должно полностью контролировать их",
				new Weight("centrism",0.1));
		Question q5 = new Question("Как вы относитесь к вопросам личных свобод?", ans5_1,ans5_2,ans5_3);

		/*
		socialism: 0
		libertarianism: 0
		monarchy: 0
		anarchism: 0
		communism: 0
		fascism: 0
		centrism: 0

		*/

		Weight socialism = new Weight("socialism",0);
		Weight libertarianism = new Weight("libertarianism",0);
		Weight monarchy = new Weight("monarchy",0);
		Weight anarchism = new Weight("anarchism",0);
		Weight communism = new Weight("communism",0);
		Weight fascism = new Weight("fascism",0);
		Weight centrism = new Weight("centrism",0);
		Quiz newQuiz("Политический тест", )

		SpringApplication.run(PoliticApplication.class, args);
	}

}
