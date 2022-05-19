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
    $perk1_image = $objArr['perk1_image'];
    $perk2_image = $objArr['perk2_image'];
    $perk3_image = $objArr['perk3_image'];
    $perk4_image = $objArr['perk4_image'];
    $nameBuild = $objArr['nameBuild'];
    $infoBuild = $objArr['infoBuild'];
    $tipeBuild = $objArr['tipeBuild'];


    try {
        $stm = $pdo->prepare(
            "INSERT INTO builds (perk1_id, perk2_id, perk3_id, perk4_id, perk1_image, perk2_image, perk3_image, perk4_image nameBuild, infoBuild, tipeBuild) 
            VALUES (:perk1, :perk2, :perk3,:perk4, :perk1_image, :perk2_image, :perk3_image, :perk4_image, :nameBuild, :infoBuild, :tipeBuild)");
        $stm -> bindValue(':perk1', $perk1_id);
        $stm -> bindValue(':perk2', $perk2_id);
        $stm -> bindValue(':perk3', $perk3_id);
        $stm -> bindValue(':perk4', $perk4_id);
        $stm -> bindValue(':nameBuild', $nameBuild);
        $stm -> bindValue(':infoBuild', $infoBuild);
        $stm -> bindValue(':tipeBuild', $tipeBuild);
        $stm -> bindValue(':perk1_image', $perk1_image);
        $stm -> bindValue(':perk2_image', $perk2_image);
        $stm -> bindValue(':perk3_image', $perk3_image);
        $stm -> bindValue(':perk4_image', $perk4_image);


        $stm -> execute();   
        
        echo "DONE";


        
     
    } catch (\Throwable $th) {
        echo "ERROR, ADIVINA TU CUAL";
    }

?>