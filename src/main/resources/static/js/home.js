/**
 *
 */

function deleteStudent(id) {
  //alert(id);

  url = "../api/student/delete/" + id;

  fetch(url, {
    method: "DELETE",
  })
    .then((response) => {
      if (response.ok) {
        return response.json().catch(() => ({}));
      } else {
        throw new Error("Network response is not ok");
      }
    })
    .then((data) => {
      console.log("sucess: ", data);
      alert("Record deleted sucessfully");
      location.reload();
    })
    .catch((error) => {
      console.log("Error", error);
      alert("Failed to delete record");
    });
}
