<?php

namespace BacklogproduitBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;


class UserStoryBacklogProduitType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('userStoryBp',null, array(
            'label' => ' ',
            'attr' => array('placeholder' => 'userStoryBp')))->add('priorityBp',null, array(
        'label' => ' ',
        'attr' => array('placeholder' => 'priority')))->add('ideBacklogFeat',  EntityType::class,
            array('class'=>'EntitiesBundle:BacklogProduit',
                'choice_label'=>'feature',
                'multiple'=>false))->add( 'save', SubmitType::class);
    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'EntitiesBundle\Entity\UserStoryBacklogProduit'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'backlogproduitbundle_userstorybacklogproduit';
    }


}
