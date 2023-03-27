let currentQuestionIndex = 0;
let questionsAndAnswers = [];
let chosenAnswers = [];
let allQuestionIndex = 7; //

const questionElement = document.getElementById("question-title"); //
const answerElements = document.querySelectorAll(".button-answer"); //

document.getElementById("curInDiv").innerHTML = currentQuestionIndex;
document.getElementById("allInDiv").innerHTML = allQuestionIndex;

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
    document.getElementById("curInDiv").innerHTML = currentQuestionIndex;
    if(currentQuestionIndex > 0) document.getElementById("button-back-id").style.visibility = "visible";      
    if(questionsAndAnswers.length <= chosenAnswers.length)
    {
        document.getElementById("form-test-id").style.display = "none";
        document.getElementById("answer").style.display = "inline-block";
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

   /*function button_answer_click(){
    currentQuestionIndex += 1;
    document.getElementById("curInDiv").innerHTML = currentQuestionIndex;
    if(currentQuestionIndex > 0) document.getElementById("button-back-id").style.visibility = "visible";
    if(currentQuestionIndex == 7){ //questionsAndAnswers.length
      document.getElementById("form-test-id").style.display = "none";
      document.getElementById("answer").style.display = "inline-block";
    }*/

  function button_back_click(){
    chosenAnswers[currentQuestionIndex].pop();
    currentQuestionIndex -= 1;
    if(currentQuestionIndex < 1) document.getElementById("button-back-id").style.visibility = "hidden";
    document.getElementById("curInDiv").innerHTML = currentQuestionIndex;
    updateQuestionsAndAnswers();
  }

fetch('/quiz/questions')
  .then(response => response.json())
  .then(data => {
    questionsAndAnswers = data.questions;
    updateQuestionsAndAnswers();
    allQuestionIndex = data.questions.length;
      document.getElementById("curInDiv").innerHTML = currentQuestionIndex;
      document.getElementById("allInDiv").innerHTML = data.questions.length;
  })
