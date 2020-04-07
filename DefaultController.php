<?php

namespace AppBundle\Controller;

use FOS\UserBundle\Model\UserInterface;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;
use EntitiesBundle\Entitity\User;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;


class DefaultController extends Controller
{
    /**
     * @Route("/", name="homepage")
     */
    public function indexAction(Request $request)
    {
        $user = $this->getUser();
        // replace this example code with whatever you need

        return $this->render('default/index.html.twig', array(
            'user' => $user,
        ));
    }

    /**
     * @Route("/back", name="back")
     */
    public function backAction(Request $request)
    {
        $user = $this->getUser();
        // replace this example code with whatever you need

        return $this->render('default/Admin.html.twig', array(
            'user' => $user,
        ));
    }
    /**
     * @Route("/backSM", name="backSM")
     */
    public function backSMAction(Request $request)
    {
        $user = $this->getUser();
        // replace this example code with whatever you need

        return $this->render('default/SM.html.twig', array(
            'user' => $user,
        ));
    }
    /**
     * @Route("/backTeam", name="backTeam")
     */
    public function backTeamAction(Request $request)
    {
        $user = $this->getUser();
        // replace this example code with whatever you need

        return $this->render('default/Team.html.twig', array(
            'user' => $user,
        ));
    }

    /**
     * @Route("/backPO", name="backPO")
     */
    public function backPOAction(Request $request)
    {

        $user = $this->getUser();
        // replace this example code with whatever you need

        return $this->render('default/PO.html.twig', array(
            'user' => $user,
        ));
    }


}
