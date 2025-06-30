/**
 * 
 */

 function showForm() {
  document.getElementById("floatingForm").style.display = "block";
}

function hideForm() {
  document.getElementById("floatingForm").style.display = "none";
}

// Optionally handle form submission
document.getElementById("subjectForm").addEventListener("submit", function(e) {
  e.preventDefault();
  const subjectName = document.getElementById("subjectName").value;


    // Ensure that the fields are not empty
    if (!subjectName) {
        alert("Please fill in all the fields.");
        return; // Prevent the request if fields are empty
    }

    const url = "../api/addSubject";

    const data = {
        subjectName: subjectName
    };

    fetch(url, {
        method: 'POST',  // Correct method to create a new resource
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
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
        alert("Subject added successfully");
        // Optionally, you can update the page or redirect after successful creation
        // For example:
        // window.location.href = "/students"; // Redirect to the students list page
        location.reload();
  hideForm();
    })
    .catch((error) => {
        console.log("Error:", error);
        alert("Failed to create subject");
    });
});
