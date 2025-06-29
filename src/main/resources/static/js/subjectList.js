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

  // You can send this via fetch or AJAX to your backend
  console.log("Subject to submit:", subjectName);

  // Clear input and hide modal
  document.getElementById("subjectName").value = "";
  hideForm();
});
