<?php

namespace EntitiesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Image
 *
 * @ORM\Table(name="image")
 * @ORM\Entity
 */
class Image
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=500, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="descr", type="blob", nullable=false)
     */
    private $descr;

    /**
     * @var string
     *
     * @ORM\Column(name="spec", type="string", length=250, nullable=false)
     */
    private $spec;


}

