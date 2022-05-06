<?php
    require 'conectaDB.php'; 
    $pdo = conectaDB();
    $obj = json_decode( file_get_contents('php://input') );   
     $objArr = (array)$obj;

     if (empty($objArr))
     {
        echo "SIN ENTRADA";                   
     }
    
    $perk1_id = $objArr['perk1_id'];
    $perk2_id = $objArr['perk2_id'];
    $perk3_id = $objArr['perk3_id'];
    $perk4_id = $objArr['perk4_id'];
    $nameBuild = $objArr['nameBuild'];
    $infoBuild = $objArr['infoBuild'];


    try {
        $stm = $pdo->prepare(
            "INSERT INTO builds (perk1_id, perk2_id, perk3_id, perk4_id, nameBuild, infoBuild) 
            VALUES (:perk1, :perk2, :perk3,:perk4,:nameBuild, :infoBuild)");
        $stm -> bindValue(':perk1', $perk1_id);
        $stm -> bindValue(':perk2', $perk2_id);
        $stm -> bindValue(':perk3', $perk3_id);
        $stm -> bindValue(':perk4', $perk4_id);
        $stm -> bindValue(':nameBuild', $nameBuild);
        $stm -> bindValue(':infoBuild', $infoBuild);

        $stm -> execute();   
        
        echo "DONE";


        
     
    } catch (\Throwable $th) {
        echo "ERROR, ADIVINA TU CUAL";
    }

?>