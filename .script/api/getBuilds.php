<?php
    require 'conectaDB.php'; 
    $pdo = conectaDB();

    try {
        $query = $pdo->prepare("SELECT * FROM builds");
        $query->execute();
        $data = $query->fetchAll(PDO::FETCH_ASSOC);
        
        echo(json_encode($data));
        //$ss = json_decode($data[0]["perks"]);
    } catch (\Throwable $th) {
        echo "ERROR, ADIVINA TU CUAL";
    }
?>
