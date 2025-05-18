/**
 * 
 * 
 * [
    {
        "subjectId": 3,
        "marks": 90,
        "studentId": 16
    },
    {
        "subjectId": 2,
        "marks": 85,
        "studentId": 16
    }
]

 */

 function addMarks(){
	 var subjectId ;
	 var marks;
	 const studentId = document.getElementById("studentId").value;
	 var data = [];
	 var subData = {};
	 
	 const url="../api/markSheet/addMarks";
	 
	 
	 document.querySelectorAll(".marksFld").forEach((field) => {
		 
	 subData = {};
		 subjectId = field.id;
		 marks = field.value;
		 
		 subData={
			 subjectId:subjectId,
			 marks:marks,
			 studentId:studentId
		 }
	 data.push(subData);
	 }
	 )
	 
	 fetch(url, {
		 method: 'POST',
		 headers:{
			 'Content-type': 'application/json',
		 },
		 body:JSON.stringify(data)
	 })
	 .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

         // Handle the response as plain text
        return response.text();
    })
    .then(data => {
        console.log('Success:', data);
        alert("successfully added marks for student");
        // Optionally, you can update the page or redirect after successful creation
        // For example:
        // window.location.href = "/students"; // Redirect to the students list page
        location.reload();
    })
    .catch((error) => {
        console.log("Error:", error);
        alert("Failed to add marks for student");
    });
 }
 
  function updateMarks(){
	 var subjectId ;
	 var marks;
	 const studentId = document.getElementById("studentId").value;
	 var data = [];
	 var subData = {};
	 
	 const url="../api/markSheet/updateMarks";
	 
	 
	 document.querySelectorAll(".marksFld").forEach((field) => {
		 
	 subData = {};
		 subjectId = field.id;
		 marks = field.value;
		 
		 subData={
			 subjectId:subjectId,
			 marks:marks,
			 studentId:studentId
		 }
	 data.push(subData);
	 }
	 )
	 
	 fetch(url, {
		 method: 'PUT',
		 headers:{
			 'Content-type': 'application/json',
		 },
		 body:JSON.stringify(data)
	 })
	 .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }

         // Handle the response as plain text
        return response.text();
    })
    .then(data => {
        console.log('Success:', data);
        alert("successfully added marks for student");
        // Optionally, you can update the page or redirect after successful creation
        // For example:
        // window.location.href = "/students"; // Redirect to the students list page
        location.reload();
    })
    .catch((error) => {
        console.log("Error:", error);
        alert("Failed to add marks for student");
    });
 }
 
function unhideSbmt() {
     document.querySelectorAll(".marksFld").forEach((field) => field.removeAttribute("readonly"))
	 document.querySelector('#updtMrksBtnSmbt').style.display='';
 }