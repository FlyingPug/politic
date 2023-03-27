let currentQuestionIndex = 0;
let questionsAndAnswers = [];
let chosenAnswers = [];

function showQuestionIndex() {
  currentQuestionIndexDiv.innerHTML = currentQuestionIndex;
}

const questionElement = document.getElementById("question");
const answerElements = document.querySelectorAll(".button-answer");

  function updateQuestionsAndAnswers() {
    if(questionsAndAnswers.length < 1) return;

    questionElement.textContent = questionsAndAnswers[currentQuestionIndex].question

    answerElements.forEach((questionsAndAnswers[currentQuestionIndex].answer, index) => {
      answerElement.textContent = questionsAndAnswers[currentQuestionIndex].answer[index];
    });
  }

  function answer(answerNumber)
  {
    if(questionsAndAnswers.length < 1) return;
    answerElement.push(answerNumber);
    currentQuestionIndex += 1;
    currentQuestionIndexDiv.innerHTML = currentQuestionIndex;
    if(questionsAndAnswers.length <= chosenAnswers.length)
    {
        currentQuestionIndex = 0;
        currentQuestionIndexDiv.innerHTML = currentQuestionIndex;
        fetch('/answers', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(chosenAnswers)
        })
          .then(response => response.json())
          .then(data => {
            document.getElementById("questions").style.display = "none";
            document.getElementById("answer").style.display = "block";
            document.getElementById("ideology-output").innerHTML = data.message;

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
    currentQuestionIndexDiv.innerHTML = currentQuestionIndex;
    allQuestionIndexDiv.innerHTML = data.questions.length;
    updateQuestionsAndAnswers()
  });



