function addStudent() {
    const uName = document.getElementById("sName").value;
    const uEmail = document.getElementById("sEmail").value;
    const uPhone = document.getElementById("sPhone").value;
    const uDept = document.getElementById("sDept").value;

    // Ensure that the fields are not empty
    if (!uName || !uEmail || !uPhone || !uDept) {
        alert("Please fill in all the fields.");
        return; // Prevent the request if fields are empty
    }

    const url = "../api/student";

    const data = {
        name: uName,
        email: uEmail,
        phone: uPhone,
        dept: uDept
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
        alert("Student created successfully");
        // Optionally, you can update the page or redirect after successful creation
        // For example:
        // window.location.href = "/students"; // Redirect to the students list page
        location.reload();
    })
    .catch((error) => {
        console.log("Error:", error);
        alert("Failed to create student");
    });
}
