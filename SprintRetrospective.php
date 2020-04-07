<?php

namespace EntitiesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * SprintRetrospective
 *
 * @ORM\Table(name="sprint_retrospective", indexes={@ORM\Index(name="ide_equipe", columns={"ide_equipe"}), @ORM\Index(name="ide_projet", columns={"ide_projet"}), @ORM\Index(name="ide_sprint", columns={"ide_sprint"})})
 * @ORM\Entity
 */
class SprintRetrospective
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_sprint_retrospective", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idSprintRetrospective;

    /**
     * @var string
     *
     * @ORM\Column(name="description_TODO", type="string", length=45, nullable=true)
     */
    private $descriptionTodo = 'NULL';

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="Date_sprint_retrospective", type="date", nullable=false)
     */
    private $dateSprintRetrospective;

    /**
     * @var \Equipe
     *
     * @ORM\ManyToOne(targetEntity="Equipe")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ide_equipe", referencedColumnName="id_equipe")
     * })
     */
    private $ideEquipe;

    /**
     * @var \Projets
     *
     * @ORM\ManyToOne(targetEntity="Projets")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ide_projet", referencedColumnName="id_projet")
     * })
     */
    private $ideProjet;

    /**
     * @var \Sprint
     *
     * @ORM\ManyToOne(targetEntity="Sprint")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ide_sprint", referencedColumnName="id_sprint")
     * })
     */
    private $ideSprint;


}

