/**
 * 
 */




 function deleteStudent(id){
	 
	 if (confirm("Are you sure you want to delete this student?")) {
		  // User clicked "OK"
		   url = "../api/student/delete/"+id;
	 
	 fetch(url,{
		 method:"DELETE",
		 
	 }).then(response => {
		 if (response.ok){
			 return response.json().catch(() => ({}));
		 }else{
			 throw new Error ("Network response was not ok");
		 }
	 })
	 .then(data => {
		 console.log("sucess: ",data);
		 alert("Record deleted sucessfully");
		 location.reload();
	 })
	 .catch((error) => {
		 console.log("Error", error);
		 alert("Failed to delete record");
	 })
		} else {
		  // User clicked "Cancel"
		  console.log("Deletion cancelled");
		}
	 
	
 }