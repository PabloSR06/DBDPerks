<?php
    require 'conectaDB.php'; 
    $pdo = conectaDB();

    try {
        $query = $pdo->prepare("SELECT * FROM builds");
        $query->execute();
        $data = $query->fetchAll();

        echo(json_encode($data));
    } catch (\Throwable $th) {
        echo "ERROR, ADIVINA TU CUAL";
    }
?>
