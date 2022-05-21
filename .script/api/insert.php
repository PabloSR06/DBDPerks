<?php
    require 'conectaDB.php'; 
    $pdo = conectaDB();
    $obj = json_decode( file_get_contents('php://input') );   
     $objArr = (array)$obj;

     if (empty($objArr))
     {
        echo "SIN ENTRADA";                   
     }
    
    $perks = $objArr['perks'];
    $nameBuild = $objArr['nameBuild'];
    $infoBuild = $objArr['infoBuild'];
    $tipeBuild = $objArr['tipeBuild'];


    try {
        $stm = $pdo->prepare(
            "INSERT INTO builds (perks,  nameBuild, infoBuild, tipeBuild) 
            VALUES (:perks, :nameBuild, :infoBuild, :tipeBuild)");
        $stm -> bindValue(':perks', $perks);
        $stm -> bindValue(':nameBuild', $nameBuild);
        $stm -> bindValue(':infoBuild', $infoBuild);
        $stm -> bindValue(':tipeBuild', $tipeBuild);


        $stm -> execute();   
        
        echo "DONE";


        
     
    } catch (\Throwable $th) {
        echo "ERROR, ADIVINA TU CUAL";
    }

?>