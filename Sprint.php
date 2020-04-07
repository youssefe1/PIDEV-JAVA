<?php

namespace EntitiesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Sprint
 *
 * @ORM\Table(name="sprint", indexes={@ORM\Index(name="id_bs", columns={"id_bs"})})
 * @ORM\Entity
 */
class Sprint
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_sprint", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idSprint;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_debut_sprint", type="date", nullable=true)
     */
    private $dateDebutSprint = 'NULL';

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_fin_sprint", type="date", nullable=true)
     */
    private $dateFinSprint = 'NULL';

    /**
     * @var integer
     *
     * @ORM\Column(name="liste_user_sroty_bs", type="integer", nullable=true)
     */
    private $listeUserSrotyBs = 'NULL';

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=45, nullable=true)
     */
    private $description = 'NULL';

    /**
     * @var \BacklogSprint
     *
     * @ORM\ManyToOne(targetEntity="BacklogSprint")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_bs", referencedColumnName="id_bs")
     * })
     */
    private $idBs;


}

