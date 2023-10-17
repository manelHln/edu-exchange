import React from 'react'
import Image from 'next/image'

const FeatureCard = ({icon, title, description}) => {
  return (
    <div className='flex gap-6 w-1/3'>
        <div>
            <Image width={45} height={45} src={icon} alt='icon' />
        </div>
        <div className='flex flex-col gap-1 w-[80%]'>
            <h4 className="text-slate-700 font-semibold text-lg">{title}</h4>
            <p className="text-slate-500 text-sm">{description}</p>
        </div>
    </div>
  )
}

export default FeatureCard