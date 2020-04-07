<?php

namespace EntitiesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Absence
 *
 * @ORM\Table(name="absence", indexes={@ORM\Index(name="ide_user", columns={"ide_user"})})
 * @ORM\Entity
 */
class Absence
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_absence", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idAbsence;

    /**
     * @var string
     *
     * @ORM\Column(name="date", type="string", length=100, nullable=false)
     */
    private $date;

    /**
     * @var string
     *
     * @ORM\Column(name="heure", type="string", length=100, nullable=false)
     */
    private $heure;

    /**
     * @var integer
     *
     * @ORM\Column(name="nbre", type="integer", nullable=false)
     */
    private $nbre;

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

