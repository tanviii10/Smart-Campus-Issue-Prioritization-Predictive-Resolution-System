fetch("/issues/all")
.then(res => res.json())
.then(data => {

let table = document.getElementById("issueTable");

data.forEach(issue => {

let row = table.insertRow();

row.insertCell(0).innerText = issue.description;
row.insertCell(1).innerText = issue.location;
row.insertCell(2).innerText = issue.category;
row.insertCell(3).innerText = issue.priority;
row.insertCell(4).innerText = issue.status;

// IMAGE COLUMN
let imgCell = row.insertCell(5);

if(issue.imageUrl){
    imgCell.innerHTML =
    `<img src="/uploads/${issue.imageUrl}" width="100">`;
}else{
    imgCell.innerText = "No Image";
}

let action = row.insertCell(6);

action.innerHTML =
`<select onchange="updateStatus('${issue.id}', this.value)">
<option>Pending</option>
<option>In Progress</option>
<option>Resolved</option>
</select>`;

});

});