<?php

namespace EntitiesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Equipe
 *
 * @ORM\Table(name="equipe", indexes={@ORM\Index(name="ide_projet", columns={"ide_projet"}), @ORM\Index(name="ide_scrum_master", columns={"ide_scrum_master"}), @ORM\Index(name="ide_perso_1", columns={"ide_perso_1"}), @ORM\Index(name="ide_perso_2", columns={"ide_perso_2"}), @ORM\Index(name="ide_perso_3", columns={"ide_perso_3"}), @ORM\Index(name="ide_perso_4", columns={"ide_perso_4"}), @ORM\Index(name="ide_perso_5", columns={"ide_perso_5"}), @ORM\Index(name="ide_perso_6", columns={"ide_perso_6"})})
 * @ORM\Entity
 */
class Equipe
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_equipe", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idEquipe;

    /**
     * @var string
     *
     * @ORM\Column(name="nom_equipe", type="string", length=20, nullable=false)
     */
    private $nomEquipe;

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
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ide_scrum_master", referencedColumnName="id")
     * })
     */
    private $ideScrumMaster;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ide_perso_1", referencedColumnName="id")
     * })
     */
    private $idePerso1;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ide_perso_2", referencedColumnName="id")
     * })
     */
    private $idePerso2;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ide_perso_3", referencedColumnName="id")
     * })
     */
    private $idePerso3;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ide_perso_4", referencedColumnName="id")
     * })
     */
    private $idePerso4;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ide_perso_5", referencedColumnName="id")
     * })
     */
    private $idePerso5;

    /**
     * @var \User
     *
     * @ORM\ManyToOne(targetEntity="User")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ide_perso_6", referencedColumnName="id")
     * })
     */
    private $idePerso6;


}

