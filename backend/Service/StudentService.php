<?php 
include_once '../classes/Student.php'; 
include_once '../connexion/Connexion.php'; 
include_once '../dao/IDao.php'; 

class StudentService implements IDao { 
    private $connexion; 
    function __construct() { 
        $this->connexion = new Connexion(); 
    } 
    public function create($o) { 
        $query = "INSERT INTO Student (nom, prenom, ville, sexe) VALUES (:nom, :prenom, :ville, :sexe)"; 
        $stmt = $this->connexion->getConnexion()->prepare($query); $stmt->execute([ ':nom' => $o->getNom(), ':prenom' => $o->getPrenom(), 
        ':ville' => $o->getVille(), ':sexe' => $o->getSexe() ]); 
        
    } 
    public function delete($o) { 
        $query = "DELETE FROM Student WHERE id = :id"; 
        $stmt = $this->connexion->getConnexion()->prepare($query); 
        $stmt->execute([':id' => $o->getId()]); 
    } 
    
    public function update($o) { 
        $query = "UPDATE Student SET nom = :nom, prenom = :prenom, ville = :ville, sexe = :sexe WHERE id = :id"; 
        $stmt = $this->connexion->getConnexion()->prepare($query); 
        $stmt->execute([ 
            ':id' => $o->getId(),
            ':nom' => $o->getNom(), 
            ':prenom' => $o->getPrenom(), 
            ':ville' => $o->getVille(), 
            ':sexe' => $o->getSexe() 
        ]); 
    } 
    
    public function findAll() { 
        $req = $this->connexion->getConnexion()->query("SELECT * FROM Student"); 
        return $req->fetchAll(PDO::FETCH_ASSOC); 
    }
    
    public function findById($id) { 
        $query = "SELECT * FROM Student WHERE id = :id"; 
        $stmt = $this->connexion->getConnexion()->prepare($query); 
        $stmt->execute([':id' => $id]); 
        return $stmt->fetch(PDO::FETCH_ASSOC); 
    }
    
    public function findAllApi() { 
        return $this->findAll(); 
    }
} 
?>
