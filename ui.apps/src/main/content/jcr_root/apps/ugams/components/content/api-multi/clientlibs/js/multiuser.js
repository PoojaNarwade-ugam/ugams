console.log("started");
var id = document.getElementById("api").innerHTML;
fetch('https://reqres.in/api/users?page='+id)
.then(response => response.json())
.then(json => {
console.log(json.data);
const userlist = json.data.map(jsondata => {
return `
<li class="card-container">
<div class="name-container">
<span class="firstName">${jsondata.first_name}</span>
<span class="lastName">${jsondata.last_name}</span>
</div>
<p class="email">${jsondata.email}</p>
<div class="image-container">
<img class="round" src="${jsondata.avatar}">
</div>
</li>
`
});console.log(userlist);
document.querySelector('.list-container').innerHTML = userlist.join('');})

