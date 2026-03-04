document.getElementById("issueForm").addEventListener("submit", function(e){

    e.preventDefault();

    let formData = new FormData(this);

    fetch("/issues/upload", {
        method: "POST",
        body: formData
    })
    .then(res => res.json())
    .then(data => {

        document.getElementById("result").innerHTML =
        "<h3>Prediction Result</h3>" +
        "Category: " + data.category + "<br>" +
        "Priority: " + data.priority + "<br>" +
        "Resolution Time: " + data.predictedResolutionTimeHours + " hours";

        alert("Issue Submitted Successfully");

    });

});