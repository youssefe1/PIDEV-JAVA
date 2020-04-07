<?php

namespace EntitiesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * BacklogSprint
 *
 * @ORM\Table(name="backlog_sprint", indexes={@ORM\Index(name="id_equipe", columns={"id_equipe"}), @ORM\Index(name="id_projet", columns={"id_projet"}), @ORM\Index(name="id_sm", columns={"id_sm"})})
 * @ORM\Entity
 */
class BacklogSprint
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_bs", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idBs;

    /**
     * @var integer
     *
     * @ORM\Column(name="liste_sprint", type="integer", nullable=true)
     */
    private $listeSprint = 'NULL';

    /**
     * @var \Equipe
     *
     * @ORM\ManyToOne(targetEntity="Equipe")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_equipe", referencedColumnName="id_equipe")
     * })
     */
    private $idEquipe;

    /**
     * @var \Projets
     *
     * @ORM\ManyToOne(targetEntity="Projets")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_projet", referencedColumnName="id_projet")
     * })
     */
    private $idProjet;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_sm", referencedColumnName="id")
     * })
     */
    private $idSm;


}

