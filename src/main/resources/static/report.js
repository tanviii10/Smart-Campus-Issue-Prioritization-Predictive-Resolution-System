document.getElementById("issueForm").addEventListener("submit", function(e){

e.preventDefault();

let form = document.getElementById("issueForm");
let formData = new FormData(form);

/* AI Loading Message */

document.getElementById("result").innerHTML =
"<div class='ai-loading'>Analyzing issue using AI...</div>";

fetch("/issues/upload",{
method:"POST",
body:formData
})

.then(res => res.json())

.then(data => {

document.getElementById("result").innerHTML =

"<h3>Issue Analysis Result</h3>"+

"<p><strong>Category:</strong> "+data.category+"</p>"+

"<p><strong>Priority:</strong> "+data.priority+"</p>"+

"<p><strong>Estimated Resolution:</strong> "+data.predictedResolutionTimeHours+" hrs</p>";

});

});