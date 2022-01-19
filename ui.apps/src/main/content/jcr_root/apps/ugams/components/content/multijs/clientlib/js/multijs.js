const section = document.querySelector('section');
var page = document.getElementById("num").innerHTML;
console.log(page);



let requestURL = 'https://reqres.in/api/users?page='+page;
let req = new XMLHttpRequest();
req.open('GET', requestURL);
req.responseType = 'json';
req.send();
req.onload = function() {
const multi = request.response;
showUsers(multi);
}
function showUsers(obj) {
const users = obj['data'];
for (let i = 0; i < users.length; i++) {
const data = document.createElement('article');
const heading = document.createElement('p');
const paragraph = document.createElement('p');
const image = document.createElement('img');
data.textContent = users[i].email;
paragraph.textContent = users[i].first_name+" "+users[i].last_name;
image.src = users[i].avatar;
data.className+="cardlist-container column";
data.appendChild(image);
data.appendChild(paragraph);
data.appendChild(heading);
section.appendChild(data);
}
}