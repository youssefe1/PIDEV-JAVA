<?php

namespace EntitiesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Tache
 *
 * @ORM\Table(name="tache", indexes={@ORM\Index(name="tache_ibfk_1", columns={"ide_user_story_bs"})})
 * @ORM\Entity
 */
class Tache
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id_Tache", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idTache;

    /**
     * @var string
     *
     * @ORM\Column(name="id_Sprint", type="string", length=45, nullable=true)
     */
    private $idSprint = 'NULL';

    /**
     * @var string
     *
     * @ORM\Column(name="date_debut_tache", type="string", length=50, nullable=true)
     */
    private $dateDebutTache = 'NULL';

    /**
     * @var string
     *
     * @ORM\Column(name="date_fin_tache", type="string", length=50, nullable=true)
     */
    private $dateFinTache = 'NULL';

    /**
     * @var string
     *
     * @ORM\Column(name="nom_tache", type="string", length=45, nullable=true)
     */
    private $nomTache = 'NULL';

    /**
     * @var string
     *
     * @ORM\Column(name="type_tache", type="string", length=45, nullable=true)
     */
    private $typeTache = 'NULL';

    /**
     * @var string
     *
     * @ORM\Column(name="liste_Personnel", type="string", length=50, nullable=true)
     */
    private $listePersonnel = 'NULL';

    /**
     * @var string
     *
     * @ORM\Column(name="description_tache", type="string", length=45, nullable=true)
     */
    private $descriptionTache = 'NULL';

    /**
     * @var string
     *
     * @ORM\Column(name="liste_nbre_heure", type="string", length=45, nullable=true)
     */
    private $listeNbreHeure = 'NULL';

    /**
     * @var string
     *
     * @ORM\Column(name="moyenne_estimation", type="string", length=45, nullable=true)
     */
    private $moyenneEstimation = 'NULL';

    /**
     * @var string
     *
     * @ORM\Column(name="etat", type="string", length=50, nullable=false)
     */
    private $etat = '\'TODO\'';

    /**
     * @var \BacklogSprint
     *
     * @ORM\ManyToOne(targetEntity="BacklogSprint")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="ide_user_story_bs", referencedColumnName="id_bs")
     * })
     */
    private $ideUserStoryBs;


}

