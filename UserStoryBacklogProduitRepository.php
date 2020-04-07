<?php

namespace BacklogproduitBundle\Repository\Entity;
use Doctrine\ORM\EntityRepository;


class UserStoryBacklogProduitRepository extends EntityRepository{

    public function getbacklog_user($nom)
    {$qb=$this->getEntityManager()->createQuery(" select b.idBacklogFeature, b.feature,p.nomProjet,u.idUserStoryBacklogProduit,u.userStoryBp,u.priorityBp from BacklogproduitBundle:BacklogProduit b join BacklogproduitBundle:UserStoryBacklogProduit u WITH  b.idBacklogFeature=u.ideBacklogFeat  join  BacklogproduitBundle:Projets p WITH p.idProjet=b.ideProjet where p.nomProjet=:titre");

        $qb->setParameter('titre',$nom);


        return $query=$qb->getResult();


    }
    public function getuser_prio1($nom)
    {$qb=$this->getEntityManager()->createQuery(" select COUNT(u.priorityBp)  from BacklogproduitBundle:BacklogProduit b join BacklogproduitBundle:UserStoryBacklogProduit u WITH  b.idBacklogFeature=u.ideBacklogFeat  join  BacklogproduitBundle:Projets p WITH p.idProjet=b.ideProjet where u.priorityBp=1 and  p.nomProjet=:titre");


        $qb->setParameter('titre',$nom);



        return $query=$qb->getSingleScalarResult();

    }
    public function getuser_prio30($nom)
    {$qb=$this->getEntityManager()->createQuery(" select COUNT(u.priorityBp)  from BacklogproduitBundle:BacklogProduit b join BacklogproduitBundle:UserStoryBacklogProduit u WITH  b.idBacklogFeature=u.ideBacklogFeat  join  BacklogproduitBundle:Projets p WITH p.idProjet=b.ideProjet where  p.nomProjet=:titre and u.priorityBp=30");


        $qb->setParameter('titre',$nom);



        return $query=$qb->getSingleScalarResult();

    }
    public function getuser_prio60($nom)
    {$qb=$this->getEntityManager()->createQuery(" select COUNT(u.priorityBp)  from BacklogproduitBundle:BacklogProduit b join BacklogproduitBundle:UserStoryBacklogProduit u WITH  b.idBacklogFeature=u.ideBacklogFeat  join  BacklogproduitBundle:Projets p WITH p.idProjet=b.ideProjet where  p.nomProjet=:titre and u.priorityBp=60");

        $qb->setParameter('titre',$nom);



        return $query=$qb->getSingleScalarResult();

    }






}