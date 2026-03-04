fetch("/issues/stats")
.then(res => res.json())
.then(data => {

createChart("categoryChart", "Issue Categories", data.category);
createChart("priorityChart", "Priority Distribution", data.priority);
createChart("statusChart", "Issue Status", data.status);

});

function createChart(id,title,data){

let labels = Object.keys(data);
let values = Object.values(data);

new Chart(document.getElementById(id),{

type:'bar',

data:{
labels:labels,

datasets:[{
label:title,
data:values,
backgroundColor:['red','blue','green','orange','purple']
}]
},

options:{
responsive:true
}

});

}