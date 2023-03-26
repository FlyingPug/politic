let currentQuestionIndex = 0;
let questionsAndAnswers = [];
let chosenAnswers = [];

const questionElement = document.getElementById("question");
const answerElements = document.querySelectorAll(".button-answer");

  function updateQuestionsAndAnswers() {
    if(questionsAndAnswers.length < 1) return;

    questionElement.textContent = questionsAndAnswers[currentQuestionIndex].question

    answerElements.forEach((answerElement, index) => {
      answerElement.textContent = questionsAndAnswers[currentQuestionIndex].answer[index];
    });
  }

  function test()
  {
    console.log("work");
  }

  function answer(answerNumber)
  {
    if(questionsAndAnswers.length < 1) return;
    chosenAnswers.push(answerNumber);
    currentQuestionIndex += 1;
    if(questionsAndAnswers.length <= chosenAnswers.length)
    {
        currentQuestionIndex = 0;
        fetch('/quiz/answers', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({'answers' : chosenAnswers})
        })
          .then(response => response.json())
          .then(data => {
            document.getElementById("questions").style.display = "none";
            document.getElementById("answer").style.display = "block";
            document.getElementById("ideology-output").innerHTML = data.ideologyName;

          });
    }
    else
    {
        updateQuestionsAndAnswers();
    }
  }

fetch('/quiz/questions')
  .then(response => response.json())
  .then(data => {
    questionsAndAnswers = data.questions;
    updateQuestionsAndAnswers()
  });

