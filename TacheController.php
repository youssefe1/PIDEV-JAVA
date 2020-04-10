<?php

namespace BSBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class TacheController extends Controller
{
    public function homeAction($id)
    {
        $user = $this->getUser()->getUsername();
        $b=$this->trah($user);
        return $this->render('BSBundle:BS:tache.html.twig',array('b'=>$b,'id'=>$id));
    }

    public function affAction()
    {
        $user = $this->getUser()->getUsername();
        $b=$this->trah($user);
        return $this->render('BSBundle:BS:tache1.html.twig',array('b'=>$b));
    }

    public function opaAction()
    {
        return $this->redirect('https://localhost:8443/workspace/14701');
    }
    public function idequipe($k)
    {
        $em = $this->getDoctrine()->getManager();
        $sql="SELECT equipe.id_equipe FROM equipe INNER JOIN fos_user on fos_user.id=equipe.ide_scrum_master WHERE fos_user.username=:dom";
        $params[':dom'] = $k;
        $em = $this->getDoctrine()->getManager();
        $stmt = $em->getConnection()->prepare($sql);
        $stmt->execute($params);
        $a = $stmt->fetchAll();
        return $a;
    }
    public function trah($k)
    {
        $em = $this->getDoctrine()->getManager();
        $sql = "select fos_user.username,fos_user.id FROM fos_user INNER join equipe ON fos_user.id=equipe.ide_scrum_master Or fos_user.id=equipe.ide_scrum_master Or fos_user.id=equipe.ide_perso_1 Or fos_user.id=equipe.ide_perso_2 Or fos_user.id=equipe.ide_perso_3 Or fos_user.id=equipe.ide_perso_4 Or fos_user.id=equipe.ide_perso_5 Or fos_user.id=equipe.ide_perso_6 WHERE equipe.id_equipe=(SELECT equipe.id_equipe FROM equipe INNER JOIN fos_user on fos_user.id=equipe.ide_scrum_master WHERE fos_user.username=:dom)";
        $params[':dom'] = $k;
        $em = $this->getDoctrine()->getManager();
        $stmt = $em->getConnection()->prepare($sql);
        $stmt->execute($params);
        $a = $stmt->fetchAll();
        return $a;
    }

    public function addAction(Request $request)
    {
        $a=$request->query->get('idus');
        $b=$request->query->get('prio');
        $c=$request->query->get('date');
        $d=$request->query->get('nom');
        $e=$request->query->get('diff');
        $f=$request->query->get('ass');
        $g=$request->query->get('desc');
        $h=0;
        $i=$request->query->get('nbr');
        $j='to do';
        $k=$request->query->get('ass');


        $sql = "INSERT INTO tache(ide_user_story_bs,id_Sprint,date_fin_tache,nom_tache, type_tache,liste_Personnel, description_tache, progress, moyenne_estimation, etat,liste_nbre_heure, user) VALUES (:a,:b,:c,:d,:e,:f,:g,:h,:i,:j,:i,:k)";
        $params[':a'] = $a;
        $params[':b'] = $b;
        $params[':c'] = $c;
        $params[':d'] = $d;
        $params[':e'] = $e;
        $params[':f'] = $f;
        $params[':g'] = $g;
        $params[':h'] = $h;
        $params[':i'] = $i;
        $params[':j'] = $j;
        $params[':k'] = $k;
        $em = $this->getDoctrine()->getManager();
        $stmt = $em->getConnection()->prepare($sql);
        $stmt->execute($params);
        return $this->redirectToRoute("user_story");
    }
}
