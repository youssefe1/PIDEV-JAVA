<?php

namespace EntitiesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Documentation
 *
 * @ORM\Table(name="documentation", indexes={@ORM\Index(name="ide_admin", columns={"ide_admin"})})
 * @ORM\Entity
 */
class Documentation
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_documentation", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idDocumentation;

    /**
     * @var string
     *
     * @ORM\Column(name="nom_documentation", type="string", length=150, nullable=false)
     */
    private $nomDocumentation;

    /**
     * @var string
     *
     * @ORM\Column(name="contenu_documentation", type="string", length=300, nullable=false)
     */
    private $contenuDocumentation;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ide_admin", referencedColumnName="id")
     * })
     */
    private $ideAdmin;


}

