function main(){
  getSummary();
}
document.addEventListener('DOMContentLoaded',main);

function getSummary(){
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      listSummary(this.responseText);
    }
  };
  xhttp.open("POST", "/Repair/querySummary", true);
  // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
  xhttp.send();
}

function listSummary(Data){
  var dataList=JSON.parse(Data);
  var summaryList=document.getElementById('summaryList');
  if(dataList.length!=0){
    for(var i=0;i<dataList.length;i++){
        var button=document.createElement("button");
        button.type="button";
        button.classList.add("list-group-item");

        var header=document.createElement("h4");
        header.classList.add("list-group-item-heading");
        header.innerHTML=dataList[i].dateStr+'===>宿舍号:'+dataList[i].userAddress;

        var conentP=document.createElement("p");
        conentP.classList.add("list-group-item-text");
        conentP.innerHTML=dataList[i].detail;

        button.appendChild(header);
        button.appendChild(conentP);
        summaryList.appendChild(button);
    }
  }
}
