<?php 

if ($_SERVER["REQUEST_METHOD"] == "POST") { 
    include_once '../service/StudentService.php'; 
    extract($_POST); $es = new StudentService(); 
    $es->create(new Student(1, $nom, $prenom, $ville, $sexe)); 
    header('Content-Type: application/json'); 
    echo json_encode($es->findAllApi()); 
} 
?>
