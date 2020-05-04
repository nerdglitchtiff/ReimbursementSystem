let logDiv = document.getElementById("logDiv")
let logBtn = document.getElementById("logBtn")
let homDiv1 = document.getElementById("hd1")
let homDiv2 = document.getElementById("hd2")
let welTag = document.getElementById("welcome")
let id = localStorage.getItem("empId")
let name = localStorage.getItem("fname") 
let status = localStorage.getItem("status")
let lname = localStorage.getItem("lname")

let remDiv = document.getElementById("remove")
async function signout(){
    localStorage.clear()
    let httpResponse = await fetch("/ExpenseReimbursementSystem/api/signout");
    window.location.replace("http://localhost:8080/ExpenseReimbursementSystem/")

}

if(window.location.href === "http://localhost:8080/ExpenseReimbursementSystem/"){


    window.onload = function(){
        if(!localStorage.getItem("fname")){logDiv.style.display="inline-block"
           
    }
        else {
            homDiv1.style.display="block"
            let name = localStorage.getItem("fname")
            welTag.innerHTML = `Welcome ${name}`
        }   
    };

    document.getElementById("logBtn").addEventListener('click',login)
    async function login(){
        let staff={}
        staff.usrnm = document.getElementById("usrnm").value
        staff.psswrd = document.getElementById("psswrd").value
        console.log(staff)
    
        let settings ={
            method: 'POST',
            headers:{'Content-Type':'application/json'},
            body: JSON.stringify(staff)
        }
        let Response = await fetch("http://localhost:8080/ExpenseReimbursementSystem/api/login",settings)
        let data = await Response.json()
        console.log(data)
        localStorage.setItem("fname",data.fname)
        localStorage.setItem("lname",data.lname)
        localStorage.setItem("empId",data.empdId)
        localStorage.setItem("status",data.status)
        window.location.replace("http://localhost:8080/ExpenseReimbursementSystem/")
        
    }


} 
if(window.location.href === "http://localhost:8080/ExpenseReimbursementSystem/requests.html" && id != null){ 
    
    document.getElementById("logInfo").innerHTML = `Logged in as: ${name} ${lname}`
    let crtDiv = document.getElementById("create")
    document.getElementById("crtBtn").addEventListener('click',function(){
        reqDiv.style.display="none"
        remDiv.style.display="none"
        statDiv.style.display="none"
        prosDiv.style.display="none"
        crtDiv.style.display="inline-block"
    })



    document.getElementById("reqBtn").addEventListener('click',reqReim)
    async function reqReim(){
        let reim ={
            empId:id
        }
        reim.amt = Number.parseFloat(document.getElementById("amt").value)
        reim.details = document.getElementById("details").value

        let settings ={
            method:'POST',
            headers:{'Content-Type':'application/json'},
            body: JSON.stringify(reim)
        };

        let httpResponse = await fetch("http://localhost:8080/ExpenseReimbursementSystem/api/addrequest",settings);
        let para = document.getElementById("crtReponse")                    
        let msg = await httpResponse.text()                                         
        alert(msg)
    }

    let prosDiv = document.getElementById("process")
    document.getElementById("procBtn").addEventListener('click',function(){
        reqDiv.style.display="none"
        remDiv.style.display="none"
        statDiv.style.display="none"
        crtDiv.style.display="none"
        prosDiv.style.display="inline-block"
    })//shows manager inputs for approval or denial


    //  THIS EDITS DATA!!!! COPY FOR REMOVE. 
  document.getElementById("updateBtn").addEventListener('click',processReq)
    async function processReq(event){
        console.log(event)
        console.log(this)
        let checkboxes = document.querySelectorAll("[type=checkbox]")// GETS ALL CHECKBOXES IN A NODELIST
        let req = Array.prototype.find.call(checkboxes, el => el.checked); //CONVERTS NODELIST TO ARRAY AND FINDS CHECKED ELEMENT
        // let req = checkboxes.find(el => el.checked)
        console.log(req)
        let reim ={
            rId: req.id,
            mgId: id
        }
        reim.amtApproved = Number.parseFloat(document.getElementById("aAmt").value)
        reim.status = document.getElementById("reqStatus").value
       

        let settings ={
            method:'POST',
            headers:{'Content-Type':'application/json'},
            body: JSON.stringify(reim)
        };

        let httpResponse = await fetch("http://localhost:8080/ExpenseReimbursementSystem/api/updatereq",settings);
        let para = document.createElement("P")                     
        let txt = document.createTextNode("Reimbursement request update submitted.")     
        para.appendChild(txt)                                        
        document.getElementById("create").appendChild(para) 
    }
  








    let hideAllExReq = function() {
        crtDiv.style.display="none"
        remDiv.style.display="none"
        statDiv.style.display="none"
        prosDiv.style.display="none"
        reqDiv.style.display="block"
        
    }



    let reqDiv = document.getElementById("req")
    document.getElementById("myBtn").addEventListener('click',myReq)
    async function myReq(){
        let httpResponse = await fetch("/ExpenseReimbursementSystem/api/byempid");
        let reqReims = await httpResponse.json()
        let td = document.getElementById("myTab")
        
        for(rr of reqReims){
            td.innerHTML = td.innerHTML + `<tr>
            <td>${rr.amt}</td>
            <td>${rr.amtApproved}</td>
            <td>${rr.empId}</td>
            <td>${rr.status}</td>
            <td>${rr.mgId}</td>
            <td>${rr.reqDate}</td>
            <td>${rr.appDate}</td>
            <td>${rr.details}</td>   
            </tr>`
        }
      
        hideAllExReq()
    }

    document.getElementById("statBtn").addEventListener('click',byStat)
    async function byStat(){
        let reim ={
            empId:id,
            status: "approved"
        }

        let settings ={
            method:'POST',
            headers:{'Content-Type':'application/json'},
            body: JSON.stringify(reim)
        };

        let httpResponse = await fetch("/ExpenseReimbursementSystem/api/bystatus", settings);
        let reqReims = await httpResponse.json()
        let td = document.getElementById("myTab")
        
        for(rr of reqReims){
            td.innerHTML = td.innerHTML + `<tr>
            <td>${rr.amt}</td>
            <td>${rr.amtApproved}</td>
            <td>${rr.empId}</td>
            <td>${rr.status}</td>
            <td>${rr.mgId}</td>
            <td>${rr.reqDate}</td>
            <td>${rr.appDate}</td>
            <td>${rr.details}</td>   
            </tr>`
        }
        hideAllExReq()
    }

    
    document.getElementById("dateBtn").addEventListener('click',byDate)
    async function byDate(){
        let reim ={
            empId:id,
            status: "denied"
        }

        let settings ={
            method:'POST',
            headers:{'Content-Type':'application/json'},
            body: JSON.stringify(reim)
        };

        let httpResponse = await fetch("/ExpenseReimbursementSystem/api/bystatus", settings);
        let reqReims = await httpResponse.json()
        let td = document.getElementById("myTab2")
        
        for(rr of reqReims){
            td.innerHTML = td.innerHTML + `<tr>
            <td>${rr.amt}</td>
            <td>${rr.amtApproved}</td>
            <td>${rr.empId}</td>
            <td>${rr.status}</td>
            <td>${rr.mgId}</td>
            <td>${rr.reqDate}</td>
            <td>${rr.appDate}</td>
            <td>${rr.details}</td>   
            </tr>`
        }
        //show div
        hideAllExReq()
        reqDiv.style.display="none"
        document.getElementById("req2").style.display="block"
    }

    document.getElementById("allBtn").addEventListener('click',all)
    async function all(){
        //make tableData
        let httpResponse = await fetch("/ExpenseReimbursementSystem/api/requests");
        let reqReims = await httpResponse.json()
        let td = document.getElementById("myTab")
        
        for(rr of reqReims){
            td.innerHTML = td.innerHTML + `<tr>
            <td>${rr.amt}</td>
            <td>${rr.amtApproved}</td>
            <td>${rr.empId}</td>
            <td>${rr.status}</td>
            <td>${rr.mgId}</td>
            <td>${rr.reqDate}</td>
            <td>${rr.appDate}</td>
            <td>${rr.details}</td>   
            </tr>`
        }
        hideAllExReq()
    }


   
    document.getElementById("allDateBtn").addEventListener('click',allDate)
    async function allDate(){
        let reim = {
            status: "approved"
        }
        let settings ={
            method:'POST',
            headers:{'Content-Type':'application/json'},
            body: JSON.stringify(reim)
        };
        let httpResponse = await fetch("/ExpenseReimbursementSystem/api/bydate", settings);
        let reqReims = await httpResponse.json()
        let td = document.getElementById("myTab")
        
        for(rr of reqReims){
            td.innerHTML = td.innerHTML + `<tr>
            <td>${rr.amt}</td>
            <td>${rr.amtApproved}</td>
            <td>${rr.empId}</td>
            <td>${rr.status}</td>
            <td>${rr.mgId}</td>
            <td>${rr.reqDate}</td>
            <td>${rr.appDate}</td>
            <td>${rr.details}</td>   
            </tr>`
        }
        hideAllExReq()
    }
    
    // document.getElementById("addIdBtn").addEventListener('click',allEmpId)
    // document.getElementById("allStat").addEventListener('click',allStatus)
    // document.getElementById("allNgridBtn").addEventListener('click',allMyId)




   
    document.getElementById("removeBtn").addEventListener('click',showPend)
    async function showPend(){
        //make tableData
        let reim = {
            status: "pending",
            empId: id
        }
        let settings ={
            method:'POST',
            headers:{'Content-Type':'application/json'},
            body: JSON.stringify(reim)
        };
        let httpResponse = await fetch("/ExpenseReimbursementSystem/api/bystatusid", settings);
        let reqReims = await httpResponse.json()
        let td = document.getElementById("remTab")
       
        for(rr of reqReims){
            console.log(rr)
            td.innerHTML = td.innerHTML + `<tr>
            <td>${rr.amt}</td>
            <td>${rr.amtApproved}</td>
            <td>${rr.empId}</td>
            <td>${rr.status}</td>
            <td>${rr.mgId}</td>
            <td>${rr.reqDate}</td>
            <td>${rr.appDate}</td>
            <td>${rr.details}</td>  
            <td><input id="${rr.rId}" type="radio"/></td> 
            </tr>`
        }
        //show div
        crtDiv.style.display="none"
        reqDiv.style.display="none"
        statDiv.style.display="none"
        prosDiv.style.display="none"
        remDiv.style.display="block"
    }

    document.getElementById("remBtn").addEventListener('click',deleteReq)
        async function deleteReq(){
         
            let radios = document.querySelectorAll("[type=radio]")// GETS ALL CHECKBOXES IN A NODELIST
            let reqs = Array.prototype.find.call(radios, el => el.checked); //CONVERTS NODELIST TO ARRAY AND FINDS CHECKED ELEMENT
            console.log(reqs)
            let reim ={
                rId: reqs.id
            }
           
            let settings ={
                method:'POST',
                headers:{'Content-Type':'application/json'},
                body: JSON.stringify(reim)
            };
            let httpResponse = await fetch("/ExpenseReimbursementSystem/api/removereq", settings);
            

       let info = await httpResponse.text()
       let td = document.getElementById("remTab")
       td.remove()
        alert(info)
        window.location.replace("http://localhost:8080/ExpenseReimbursementSystem/requests.html")
       

        }
    

    let statDiv = document.getElementById("stat")
    document.getElementById("allStat").addEventListener('click',processReqs)
    async function processReqs(){
        //make tableData
        let reim = {
            status: "pending"
        
        }
        let settings ={
            method:'POST',
            headers:{'Content-Type':'application/json'},
            body: JSON.stringify(reim)
        };
        let httpResponse = await fetch("/ExpenseReimbursementSystem/api/bystatus", settings);
        let reqReims = await httpResponse.json()
        let td = document.getElementById("statTab")
        
        for(rr of reqReims){
            td.innerHTML = td.innerHTML + `<tr>
            <td>${rr.amt}</td>
            <td>${rr.amtApproved}</td>
            <td>${rr.empId}</td>
            <td>${rr.status}</td>
            <td>${rr.mgId}</td>
            <td>${rr.reqDate}</td>
            <td>${rr.appDate}</td>
            <td>${rr.details}</td>  
            <td><input id="${rr.rId}" type="checkbox"/></td> 
            </tr>`
        }
        //show div
        crtDiv.style.display="none"
        reqDiv.style.display="none"
        remDiv.style.display="none"
        prosDiv.style.display="none"
        statDiv.style.display="block"

    }


} else if(window.location.href === "http://localhost:8080/ExpenseReimbursementSystem/requests.html" && id === null) {
    alert("Must login to access these fields")
    window.location.replace("http://localhost:8080/ExpenseReimbursementSystem/")
}