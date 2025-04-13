<!DOCTYPE html>
<html>
<head><title>Attendance Form</title></head>
<body>
  <form action="submitAttendance" method="post">
    Student Name: <input type="text" name="name" required><br>
    Roll Number: <input type="text" name="roll" required><br>
    Present? <input type="checkbox" name="status" value="Present"><br>
    <input type="submit" value="Submit">
  </form>
</body>
</html>
