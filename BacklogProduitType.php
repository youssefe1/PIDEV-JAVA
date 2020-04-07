<?php

namespace BacklogproduitBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;


class BacklogProduitType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('feature',null, array(
            'label' => ' ',
            'attr' => array('placeholder' => 'feature')))->add('ideProjet', EntityType::class,
            array('class'=>'EntitiesBundle:Projets',
                'choice_label'=>'nomProjet',
                'multiple'=>false))->add( 'save', SubmitType::class);
    }
    /**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'EntitiesBundle\Entity\BacklogProduit'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'backlogproduitbundle_backlogproduit';
    }


}
