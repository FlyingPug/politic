
  let currentQuestionIndex = 0;
  let questionsAndAnswers = [];
  let chosenAnswers = [];
  let allQuestionIndex = 7;

  const questionElement = document.getElementById("question");
  const answerElements = document.querySelectorAll(".button-answer");

  document.getElementById("curInDiv").innerHTML = currentQuestionIndex;
  document.getElementById("allInDiv").innerHTML = allQuestionIndex;

    function updateQuestionsAndAnswers() {
      if (questionsAndAnswers.length < 1) return;

        questionElement.textContent = questionsAndAnswers[currentQuestionIndex].question;

        answerElements.forEach((answerElement, index) => {
        answerElement.textContent = questionsAndAnswers[currentQuestionIndex].answer[index];
      });
    }

    function answer(answerNumber)
    {
      if(questionsAndAnswers.length < 1) return;
      answerElement.push(answerNumber);
    
      if(questionsAndAnswers.length <= chosenAnswers.length)
      {
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

  function button_answer_click(){
    currentQuestionIndex += 1;
    document.getElementById("curInDiv").innerHTML = currentQuestionIndex;
    if(currentQuestionIndex > 0) document.getElementById("button-back-id").style.visibility = "visible";
    if(currentQuestionIndex == 7){ //questionsAndAnswers.length
      document.getElementById("form-test-id").style.display = "none";
      document.getElementById("answer").style.display = "inline-block";
    }
    
  }

  function button_back_click(){
    currentQuestionIndex -= 1;
    if(currentQuestionIndex < 1) document.getElementById("button-back-id").style.visibility = "hidden";
    document.getElementById("curInDiv").innerHTML = currentQuestionIndex;
  }

  fetch('/quiz/questions')
    .then(response => response.json())
    .then(data => {
      questionsAndAnswers = data.questions;
      /*allQuestionIndex = data.questions.length;
      document.getElementById("curInDiv").innerHTML = currentQuestionIndex;
      document.getElementById("allInDiv").innerHTML = data.questions.length;
      updateQuestionsAndAnswers()*/
    });
