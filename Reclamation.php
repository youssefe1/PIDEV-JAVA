<?php

namespace EntitiesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Reclamation
 *
 * @ORM\Table(name="reclamation", indexes={@ORM\Index(name="ide_personnel", columns={"ide_personnel"})})
 * @ORM\Entity
 */
class Reclamation
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_reclamation", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idReclamation;

    /**
     * @var string
     *
     * @ORM\Column(name="sujet_reclamation", type="string", length=250, nullable=false)
     */
    private $sujetReclamation;

    /**
     * @var string
     *
     * @ORM\Column(name="Etat", type="string", length=50, nullable=false)
     */
    private $etat;

    /**
     * @var string
     *
     * @ORM\Column(name="description_reclamation", type="string", length=300, nullable=false)
     */
    private $descriptionReclamation;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ide_personnel", referencedColumnName="id")
     * })
     */
    private $idePersonnel;


}

