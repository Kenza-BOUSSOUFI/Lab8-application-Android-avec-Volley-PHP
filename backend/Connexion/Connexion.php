<?php 
class Connexion { 
    private $connexion;
    public function __construct() { 
        try { $this->connexion = new PDO("mysql:host=localhost;dbname=école_lab8;charset=utf8", "root", ""); 
        $this->connexion->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); 
        }catch (PDOException $e) { die('Erreur lors de connexion : ' . $e->getMessage());} 
    } 
    public function getConnexion() { return $this->connexion; } 
} 
?>
