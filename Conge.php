<?php

namespace EntitiesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Conge
 *
 * @ORM\Table(name="conge", indexes={@ORM\Index(name="ide_user", columns={"ide_user"})})
 * @ORM\Entity
 */
class Conge
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_Conge", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idConge;

    /**
     * @var string
     *
     * @ORM\Column(name="date_debut", type="string", length=200, nullable=false)
     */
    private $dateDebut;

    /**
     * @var string
     *
     * @ORM\Column(name="date_fin", type="string", length=200, nullable=false)
     */
    private $dateFin;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=250, nullable=false)
     */
    private $description;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ide_user", referencedColumnName="id")
     * })
     */
    private $ideUser;


}

