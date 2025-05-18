/**
 * 
 */

 function updateStudent(){
	 const uName = document.getElementById("sName").value;
	 const uEmail = document.getElementById("sEmail").value;
	 const uPhone = document.getElementById("sPhone").value;
	 const uDept = document.getElementById("sDept").value;
	 const ID = document.getElementById("sId").value;

	 const url="../api/student/"+ID
	 
	 const data = {
		 name:uName,
		 email:uEmail,
		 phone:uPhone,
		 dept:uDept
	 }
	 
	 fetch(url, {
		 method: 'PUT',
		 headers:{
			 'content-type':'application/json',
		 },
		 body:JSON.stringify(data)
	 })
	 .then(response => {
    if (response.ok) {
        return response.json().catch(() => ({})); // If no JSON, still continue
    } else {
        throw new Error('Network response was not ok.');
    }
})
	 .then(data => {
		 console.log('sucess:',data);
		 alert("data updated sucessfully");
	 })	
	 .catch((error) => {
		 console.log("Error:",error);
		 alert("failed to update data");
		 
	 });
 }